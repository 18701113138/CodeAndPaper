# /user/bin/env python
# -*-coding:utf-8-*-
# 读取文件，并返回整形二维数组
from code.clustering.fuzzy_c_means import FCM
from code.ranking.ranking_feature import *


def read(file):
    file_obj = open(file)
    try:
        file_line = file_obj.readlines()
        num = []
        for line in file_line:
            num_str = line.split(' ')
            num_int = [int(str) for str in num_str]
            num.append(num_int)
        return num
    finally:
        file_obj.close()
        return None


# 获取路径和结果信息
def get_trace_and_result(num):
    trace = []
    result = []
    for n in num:
        trace.append(reversed(n[:-2]))
        result.append(n[-1])
    return (trace, result)


# 获取向量信息
def get_vectors(num):
    vectors = num
    vectors = [1 if n > 0 else 0 for vector in vectors for n in vector]
    return vectors


# 初始化Feature信息
def init_feature():
    f1 = TarFeature
    f2 = OchiFeature
    f3 = JacFeature
    f4 = Gpl3Feature
    f5 = NaiFeature
    return [f1, f2, f3, f4, f5]


if __name__ == "__main__":
    num = read("a.txt")
    assert (num != None)
    (trace,result) = get_trace_and_result(num)
    # 偶然正确性
    fcm = FCM
    u = fcm.alg_fcm(trace, fcm.init_u(len(trace), 2), 3, 2, 0.01)

