# /user/bin/env python
# -*-coding:utf-8-*-

import math

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

        num_fea = len(features)
        num_vec = len(vectors)
        for i in range(num_fea):
            # Get weak ranking ht : X -> R.
            weak_ranking = []
            for j in range(num_vec):
                if isinstance(features[i], Feature):
                    weak_ranking.append(features[i].cal(vectors[j]))  # 计算每个函数的怀疑度
            # min_max_scaler = preprocessing.MinMaxScaler()
            # weak_ranking = min_max_scaler.fit_transform(weak_ranking)

            # cal a
            a.append(self.cal_a(self, distribution, weak_ranking))
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
                    r += D[i][j] * (H[j] - H[i])
        a = 0.5 * math.log((1 + r) / (1 - r), math.e)
        return a

    # 更新distribution
    def update_D(self, D, H, a):
        Z = 0
        D_next = D;
        row = len(D)
        col = len(D[0])
        for i in range(row):
            for j in range(col):
                if (D[i][j] > 0):
                    D_next[i][j] = D[i][j] * math.exp(a * (H[j] - H[i]))
                    Z += D_next[i][j]
        D_next = [D_next[i][j] / Z for i in range(row) for j in range(col)]
        return D_next
