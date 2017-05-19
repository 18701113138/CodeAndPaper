# /user/bin/env python
# -*-coding:utf-8-*-
# 读取文件，并返回整形二维数组
from code.clustering.fuzzy_c_means import FCM
from code.ranking.ranking_feature import BoostFeature
from code.train.data_statistics import DataStatistics
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
    trace1 = trace
    result1 = result
    tmp = 0
    for i in num_result[del_which]:
        i -= tmp
        tmp += 1
        trace1.remove(trace1[i])
        result1.remove(result1[i])
    rate = len(num_result[del_which]) * 1.0 / num
    return (trace1, result1, rate)


if __name__ == "__main__":
    # 训练
    has_trained = False
    boost_feature = BoostFeature
    if has_trained == False:
        boost_feature = Train.start('./train/path','./train/pairs')


    [data, trace, result] = FileIO.read_a_file('./train/path/1.txt')
    assert (len(data) > 0)
    # 偶然正确性
    fcm = FCM
    (u ,k)= fcm.alg_fcm(fcm,trace, fcm.init_u(fcm,len(trace), 2), 3, 2, 0.01)
    # 删除偶然正确性元素
    (trace1, result1, rate) = delete_accidental_correctness(trace, result, u)
    # print(trace1, result1, rate)

    # 排名
    vectors = DataStatistics.get_veators_from_a_program(trace1,result1);
    ans = [boost_feature.cal(boost_feature,vector) for vector in vectors];
    print(ans)
    ans.sort(reverse=True)
    print(ans)

