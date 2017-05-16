# /user/bin/env python
# -*-coding:utf-8-*-
from abc import abstractmethod
import math


class RankingAlgorithm:
    @staticmethod
    def tarantula(self, ep, ef, np, nf):
        if ep == 0 and ef == 0:
            raise Exception("Not Allowed ep and ef equal zero", ep, ef)
        elif ep == 0:
            return 1
        elif ef == 0:
            return 0
        else:
            return 1.0 / (1.0 + (1.0 + nf / ef) / (1.0 + np / ep))

    @staticmethod
    def ochiai(self, ep, ef, np, nf):
        if ep == 0 and ef == 0:
            raise Exception("Not Allowed ep and ef equal zero", ep, ef)
        elif ef + nf == 0:
            return 0
        else:
            return 1.0 * ef / math.sqrt((ep + ef) * (ef + nf))

    @staticmethod
    def jaccard(self, ep, ef, np, nf):
        if ep == 0 and ef == 0 and nf == 0:
            raise Exception("Not Allowed ep and ef and nf equal zero", ep, ef, nf)
        else:
            return 1.0 * ef / (ef + ep + nf)

    @staticmethod
    def naish2(self, ep, ef, np, nf):
        return ef - 1.0 * ep / (ep + np + 1)

    @staticmethod
    def gp13(self, ep, ef, np, nf):
        if ep == 0 and ef == 0:
            return 1
        else:
            return ef * (1 + 1.0 / (2 * ep + ef))


class Feature:
    @abstractmethod
    def cal(self, x): pass


class TarFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.tarantula(self, x[0], x[1], x[2], x[3])


class OchiFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.ochiai(self, x[0], x[1], x[2], x[3])


class JacFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.jaccard(self, x[0], x[1], x[2], x[3])


class Gpl3Feature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.gp13(self, x[0], x[1], x[2], x[3])


class NaiFeature(Feature):
    def cal(self, x):
        assert (len(x) == 4)
        return RankingAlgorithm.naish2(self, x[0], x[1], x[2], x[3])
