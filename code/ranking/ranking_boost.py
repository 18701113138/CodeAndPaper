# /user/bin/env python
# -*-coding:utf-8-*-
import copy
import math
from time import sleep

from sklearn import preprocessing

from code.ranking.ranking_feature import Feature


class RankBoost:
    # vectors是向量集合，以list表示n*4
    # features是特征列表，即排序候选者,以list表示
    # distribution是初始化特征值矩阵，以list（list）表示
    # 返回a
    def boost(self, vectors, features, distribution):
        assert (len(vectors) > 0)
        assert (len(features) > 0)

        a = []
        loss = []

        num_fea = len(features)
        num_vec = len(vectors)
        for i in range(num_fea):
            # Get weak ranking ht : X -> R.
            weak_ranking = []
            for j in range(num_vec):
                weak_ranking.append(features[i].cal(features[i], vectors[j]))  # 计算每个函数的怀疑度
            min_max_scaler = preprocessing.MinMaxScaler()
            weak_ranking = min_max_scaler.fit_transform(weak_ranking)

            # cal a and loss
            [a_i,loss_i] = self.cal_a(self, distribution, weak_ranking)
            a.append(a_i)
            loss.append(loss_i)
            # update distrubution
            distribution = self.update_D(self, distribution, weak_ranking, a[i])
        # 归一化
        sum = 0.0
        for t in a:
            sum += t
        a = [t/sum for t in a]
        # 返回
        return a

    # D是distribution，H是未排序的怀疑度值
    # 返回a值
    def cal_a(self, D, H):
        r = 0
        row = len(D)
        col = len(D[0])
        for i in range(row):
            for j in range(col):
                if (D[i][j] > 0):
                    if(H[j] - H[i] < 0):
                        r += D[i][j]*(H[j] - H[i])
                    else:
                        pass;
                        # r -= D[i][j]
        loss = abs(r)
        print('loss',abs(r));
        # a = 0 if r <= -1 or r >= 1 else 0.5 * math.log((1 - r) / (r), math.e)
        a = 0 if r <= -1 or r >= 1 else 0.5 * math.log((1 + r) / (1 - r), math.e)
        return [a,loss]

    # 更新distribution
    def update_D(self, D, H, a):
        Z = 0
        D_next = copy.copy(D)
        row = len(D)
        col = len(D[0])
        for i in range(row):
            for j in range(col):
                if (D[i][j] > 0):
                    D_next[i][j] = D[i][j] * math.exp(a*(H[j] - H[i]))
                    Z += D_next[i][j]
        for i in range(row):
            for j in range(col):
                if (D[i][j] > 0):
                    D_next[i][j] /= Z
        return D_next
