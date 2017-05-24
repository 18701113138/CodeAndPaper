# /user/bin/env python
# -*-coding:utf-8-*-
from abc import abstractmethod
import math

from sklearn import preprocessing


class RankingAlgorithm:
    @staticmethod
    def tarantula(ep, ef, np, nf):
        if ep == 0 and ef == 0:
            raise Exception("Not Allowed ep and ef equal zero", ep, ef)
        elif ep == 0:
            return 1
        elif ef == 0:
            return 0
        else:
            return 1.0 / (1.0 + (1.0 + nf / ef) / (1.0 + np / ep))

    @staticmethod
    def ochiai(ep, ef, np, nf):
        if ep == 0 and ef == 0:
            raise Exception("Not Allowed ep and ef equal zero", ep, ef)
        elif ef + nf == 0:
            return 0
        else:
            return 1.0 * ef / math.sqrt((ep + ef) * (ef + nf))

    @staticmethod
    def jaccard(ep, ef, np, nf):
        if ep == 0 and ef == 0 and nf == 0:
            raise Exception("Not Allowed ep and ef and nf equal zero", ep, ef, nf)
        else:
            return 1.0 * ef / (ef + ep + nf)

    @staticmethod
    def naish2(ep, ef, np, nf):
        return ef - 1.0 * ep / (ep + np + 1)

    @staticmethod
    def gp13(ep, ef, np, nf):
        if ep == 0 and ef == 0:
            return 1
        else:
            return ef * (1 + 1.0 / (2 * ep + ef))


class Feature:
    @abstractmethod
    def cal(self, x): pass


class BoostFeature(Feature):
    feature = []
    a = []

    def __init__(self, feature, a):
        self.feature = feature
        self.a = a

    def cal(self, vectors):
        assert (len(self.feature) == len(self.a))
        assert (len(vectors) > 0)
        answer = []
        lenth_vec = len(vectors)
        lenth_a = len(self.a)
        tmp = []
        for i in range(lenth_a):
            tmpp = []
            for j in range(lenth_vec):
                tmpp.append(self.feature[i].cal(self.feature[i],vectors[j]))
            min_max_scaler = preprocessing.MinMaxScaler()
            tmp.append(min_max_scaler.fit_transform(tmpp))
        for i in range(lenth_vec):
            sum = 0
            for j in range(lenth_a):
                sum += self.a[j]*tmp[j][i]
            answer.append(sum)
        return answer


class TarFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.tarantula(x[0], x[1], x[2], x[3])


class OchiFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.ochiai(x[0], x[1], x[2], x[3])


class JacFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.jaccard(x[0], x[1], x[2], x[3])


class Gpl3Feature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.gp13(x[0], x[1], x[2], x[3])


class NaiFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.naish2(x[0], x[1], x[2], x[3])
