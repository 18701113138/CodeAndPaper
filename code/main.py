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


# 删除偶然正确性测试用例，返回删除后的结果和删除比例
def delete_accidental_correctness(trace, result, u):
    u_01 = [1 if tmp > 0.5 else 0 for t in u for tmp in t]
    # 统计
    num_correct_c1 = []
    num_wrong_c1 = []
    num_correct_c2 = []
    num_wrong_c2 = []
    num = len(u)
    for i in range(num):
        if u_01[i][0] == 1:
            if result[i] == 1:
                num_correct_c1.append(i)
            else:
                num_wrong_c1.append(i)
        else:
            if result[i] == 1:
                num_correct_c2.append(i)
            else:
                num_wrong_c2.append(i)
    num_result = [num_correct_c1, num_wrong_c1, num_correct_c2, num_wrong_c2]
    # 删除
    del_which = 0 if len(num_result[1]) > len(num_result[3]) else 2
    trace1 = trace
    result1 = result
    for i in num_result[del_which]:
        trace1.remove(i)
        result1.remove(i)
    rate = len(num_result[del_which]) * 1.0 / num
    return (trace1, result1, rate)


# 获取向量信息
def get_vectors(trace, result):
    num = []
    len = len(trace)
    for i in range(len):
        num.append(trace[i])
        num[i].append(result[i])
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
    (trace, result) = get_trace_and_result(num)
    # 偶然正确性
    fcm = FCM
    u = fcm.alg_fcm(trace, fcm.init_u(len(trace), 2), 3, 2, 0.01)
    # 删除偶然正确性元素
    (trace1, result1, rate) = delete_accidental_correctness(trace, result, u)
    print(trace1, result1, rate)

    # 训练
    # 1.获取向量信息，初始化Feature信息
    vectors = get_vectors(trace1, result1)
    features = init_feature()


