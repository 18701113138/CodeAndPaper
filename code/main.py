# /user/bin/env python
# -*-coding:utf-8-*-
# 读取文件，并返回整形二维数组
from code.clustering.fuzzy_c_means import FCM
from code.train.data_statistics import DataStatistics
from code.train.file_io import FileIO





# 删除偶然正确性测试用例，返回删除后的结果和删除比例
from code.train.train import Train


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


if __name__ == "__main__":
    # 训练
    has_trained = False
    boost_feature = None
    if has_trained == False:
        boost_feature = Train.start('./path','./pairs')


    [data, trace, result] = FileIO.read_a_file('me.txt')
    assert (len(data) > 0)
    # 偶然正确性
    fcm = FCM
    u = fcm.alg_fcm(trace, fcm.init_u(len(trace), 2), 3, 2, 0.01)
    # 删除偶然正确性元素
    (trace1, result1, rate) = delete_accidental_correctness(trace, result, u)
    print(trace1, result1, rate)

    # 排名
    vectors = DataStatistics.get_veators_from_a_program(trace1,result1);
    ans = [boost_feature.cal(vector) for vector in vectors];
    ans.sort(reverse=True)
    print(ans)

