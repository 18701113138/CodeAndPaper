# /user/bin/env python
# -*-coding:utf-8-*-
# 读取文件，并返回整形二维数组
import copy
import os
from time import sleep

import subprocess
from sklearn import preprocessing

from code.clustering.fuzzy_c_means import FCM
from code.ranking.ranking_feature import BoostFeature, TarFeature, OchiFeature
from code.train.data_statistics import DataStatistics, JacFeature, Gpl3Feature, NaiFeature
from code.train.file_io import FileIO

# 删除偶然正确性测试用例，返回删除后的结果和删除比例
from code.train.train import Train


def delete_accidental_correctness(trace, result, u):
    u_01 = [[1 if tmp > 0.5 else 0 for tmp in t] for t in u]
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
    trace1 = copy.copy(trace)
    result1 = copy.copy(result)
    tmp = 0
    for i in num_result[del_which]:
        i -= tmp
        tmp += 1
        trace1.remove(trace1[i])
        result1.remove(result1[i])
    rate = len(num_result[del_which]) * 1.0 / num
    return (trace1, result1, rate)


def get_key(x):
    return x[1]


def output(name, vectors):
    # 格式化输入
    print(name)
    no_vector = [[i, vectors[i]] for i in range(len(vectors))]
    no_vector.sort(key=get_key,reverse=True)
    for i in range(len(no_vector)):
        print('%02d : %.5lf'%(no_vector[i][0],no_vector[i][1]))

def outputs(names, vectors):
    # 格式化输入
    num = len(names)
    # 输出名字
    for i in range(num - 1):
        print('{:<13}'.format(names[i]),end='   ')
    print('{:<12}'.format(names[-1]))
    # 排序
    no_vectors = []
    for i in range(num):
        no_vector = [[j, vectors[i][j]] for j in range(len(vectors[i]))]
        no_vector.sort(key=get_key,reverse=True)
        no_vectors.append(no_vector)
    # 输出
    row = len(no_vectors[0])
    for i in range(row):
        for j in range(num-1):
            print('%02d : %8.5f'%(no_vectors[j][i][0],no_vectors[j][i][1]), end='   ')
        print('%02d : %8.5f' % (no_vectors[-1][i][0], no_vectors[-1][i][1]))


if __name__ == "__main__":
    # 训练
    has_trained = False
    boost_feature = BoostFeature
    if has_trained == False:
        boost_feature = Train.start('./train/path', './train/pairs')

    [data, trace, result] = FileIO.read_a_file('./train/path/2.txt')
    assert (len(data) > 0)
    # 偶然正确性
    fcm = FCM
    (u, k) = fcm.alg_fcm(fcm, trace, fcm.init_u(fcm, len(trace), 2), 3, 2, 0.01)
    # 删除偶然正确性元素
    (trace1, result1, rate) = delete_accidental_correctness(trace, result, u)
    # print(trace1, result1, rate)

    # 排名
    if rate > 0.05:
        vectors = DataStatistics.get_veators_from_a_program(trace, result);
    else:
        vectors = DataStatistics.get_veators_from_a_program(trace1, result1);

    ans = boost_feature.cal(boost_feature, vectors);
    # output('boost',ans)
    sleep(0.5)
    print('\n\n')
    # print(boost_feature.a)
    tar = TarFeature
    oci = OchiFeature
    jac = JacFeature
    gp = Gpl3Feature
    nai = NaiFeature
    ans2 = [tar.cal(tar, vector) for vector in vectors]
    ans3 = [oci.cal(tar, vector) for vector in vectors]
    ans4 = [jac.cal(tar, vector) for vector in vectors]
    ans5 = [gp.cal(tar, vector) for vector in vectors]
    ans6 = [nai.cal(tar, vector) for vector in vectors]
    outputs(['a-tar','a-ochi','a-jac','a-gp','a-nai'],[[boost_feature.a[i]] for i in range(len(boost_feature.a))])
    print('\n')
    outputs(['boost','tar','ochi','jac','gp','nai'],[ans,ans2,ans3,ans4,ans5,ans6])
