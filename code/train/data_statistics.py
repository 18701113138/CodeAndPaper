# /user/bin/env python
# -*-coding:utf-8-*-
from code.ranking.ranking_feature import *


class DataStatistics:
    # 初始化Feature信息
    @staticmethod
    def init_feature():
        f1 = TarFeature
        f2 = OchiFeature
        f3 = JacFeature
        f4 = Gpl3Feature
        f5 = NaiFeature
        return [f1, f2, f3, f4, f5]

    # 根据数据得到一个程序中的向量
    @staticmethod
    def get_veators_from_a_program(trace, result):
        assert (len(trace) > 0)
        assert (len(trace[0]) > 0)
        assert (len(trace) == len(result))

        vectors = []

        row = len(trace)
        col = len(trace[0])
        for j in range(col):
            vector = [0, 0, 0, 0]
            for i in range(row):
                if list(trace[i])[j] > 0 and result[i] == 1:
                    vector[0] += 1
                elif list(trace[i])[j] > 0 and result[i] == 0:
                    vector[1] += 1
                elif list(trace[i])[j] == 0 and result[i] == 1:
                    vector[2] += 1
                elif list(trace[i])[j] == 0 and result[i] == 0:
                    vector[3] += 1
            vectors.append(vector)

        return vectors

    # 根据数据得到一堆程序中的向量
    @staticmethod
    def get_veators_from_programs(data_trace_result):
        vectors = []
        for dta in data_trace_result:
            vectors_tmp = DataStatistics.get_veators_from_a_program(dta[1],dta[2]);
            vectors += vectors_tmp
        return vectors

    # 合并两个矩阵
    @staticmethod
    def merge_two_matrix(matrix_a, matrix_b):
        assert (len(matrix_a) >= 0)
        assert (len(matrix_b) >= 0)
        assert (len(matrix_a)==0 or len(matrix_a[0]) >= 0)
        assert (len(matrix_b)==0 or len(matrix_b[0]) >= 0)
        lenA = 0 if len(matrix_a) == 0 else len(matrix_a[0])
        lenB = 0 if len(matrix_b) == 0 else len(matrix_b[0])
        zeroA = [0 for i in range(lenA)]
        zeroB = [0 for i in range(lenB)]
        matrix = []
        for i in range(lenA):
            matrix.append(matrix_a[i] + zeroB)
        for i in range(lenB):
            matrix.append(zeroA + matrix_b[i])
        return matrix

    # 合并多个矩阵
    @staticmethod
    def merge(matrixs):
        matrix = []
        for m in matrixs:
            matrix = DataStatistics.merge_two_matrix(matrix, m)
            # print(len(matrix))
            # print(len(matrix[0]))
        # 归一化
        row = len(matrix)
        col = len(matrix[0])
        num = 0
        for i in range(row):
            for j in range(col):
                if matrix[i][j] > 0:
                    num += 1
        for i in range(row):
            for j in range(col):
                if matrix[i][j] > 0:
                    matrix[i][j] /= num

        return matrix
