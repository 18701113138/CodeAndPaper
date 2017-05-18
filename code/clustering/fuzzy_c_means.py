# /user/bin/env python
# -*-coding:utf-8-*-

import sys
import numpy as np


class FCM:
    # 初始化隶属度矩阵
    def init_u(self, n, C):
        assert (len(n) == 1 and len(C) == 1)
        t = [1 / C] * C
        u = [t] * n
        return u

    # 给定同维向量数据集合points，数目为n，将其聚为C类，m为权重值，u为初始匹配度矩阵（n*C），采用闵式距离算法，其参数为p，迭代终止条件为终止值e（取值范围(0，1））及终止轮次
    # 计算停止时返回计算的轮次和匹配度矩阵，返回值为一个tuple:(最终计算过后的u矩阵,计算轮次（从0开始）)
    def alg_fcm(self, points, u, m, p, e, terminateturn=10000):
        assert (len(points) == len(u));
        assert (len(points) > 0);
        assert (len(u[0]) > 0);
        assert (m > 0);
        assert (p > 0);
        assert (e > 0);

        u1 = u;
        k = 0;
        while (True):
            # calculate one more turn
            u2 = self.fcm_oneturn(points, u1, m, p);
            # max difference between u1 and u2
            maxu = self.fcm_maxu(u1, u2);

            if (maxu < e):
                break;
            u1 = u2;
            k = k + 1;
            if k > terminateturn:
                break;

        return (u2, k);

    # 每一轮计算的函数fcm_oneturn代码如下，参数与主函数相同，返回值只有匹配度矩阵
    def fcm_oneturn(self, points, u, m, p):
        assert (len(points) == len(u));
        assert (len(points) > 0);
        assert (len(u[0]) > 0);
        assert (m > 0);
        assert (p > 0);

        n = len(points);
        c = len(u[0]);

        # 迭代c，即计算各类质心，返回list
        centroids = self.fcm_c(points, u, m);
        assert (len(centroids) == c);

        # 迭代u，更新隶属度矩阵u
        u2 = self.fcm_u(points, centroids, m, p);
        assert (len(u2) == n);
        assert (len(u2[0]) == c);

        return u2;

    # 计算终止值的函数
    # 目标函数J趋于稳定时，隶属度矩阵也趋于稳定，这里比较的是隶属度矩阵
    def fcm_maxu(u1, u2):
        assert (len(u1) == len(u2));
        assert (len(u1) > 0);
        assert (len(u1[0]) > 0);

        ret = 0;
        n = len(u1);
        c = len(u1[0]);
        for i in range(n):
            for j in range(c):
                ret = max(np.fabs(u1[i][j] - u2[i][j]), ret);  # 找出最大差值

        return ret;

    # 每一个轮次计算匹配度矩阵的函数：
    # 参数centroids表示每个类别的质心集合
    def fcm_u(self, points, centroids, m, p):
        assert (len(points) > 0);
        assert (len(centroids) > 0);
        assert (m > 1);
        assert (p > 0);

        n = len(points);
        c = len(centroids);
        ret = [[0 for j in range(c)] for i in range(n)];
        for i in range(n):
            for j in range(c):
                sum1 = 0;
                d1 = self.dis_minkowski(points[i], centroids[j], p);
                for k in range(c):
                    d2 = self.dis_minkowski(points[i], centroids[k], p);
                    if d2 != 0:
                        sum1 += np.power(d1 / d2, float(2) / (float(m) - 1));
                if sum1 != 0:
                    ret[i][j] = 1 / sum1;

        return ret;

    # 每一个轮次计算类别质心的函数
    def fcm_c(self, points, u, m):
        assert (len(points) == len(u));
        assert (len(points) > 0);
        assert (len(u[0]) > 0);
        assert (m > 0);

        n = len(points);
        c = len(u[0]);
        ret = [];
        for j in range(c):
            sum1 = 0;
            sum2 = 0;
            for i in range(n):
                sum2 += np.power(u[i][j], m);
                sum1 += np.dot(points[i], np.power(u[i][j], m));
            if sum2 != 0:
                cj = sum1 / sum2;
            else:
                cj = [0 for d in range(len(points[i]))];
            ret.append(cj);

        return ret;
