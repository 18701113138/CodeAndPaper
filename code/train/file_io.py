# /user/bin/env python
# -*-coding:utf-8-*-

import os


class FileIO:
    # 读取数据和pairs
    @staticmethod
    def read(path_data, path_pairs):
        # 获取文件名
        data_files = os.listdir(path_data)
        pairs_files = os.listdir(path_pairs)
        # 获取文件数量
        len_data = len(data_files)
        len_pair = len(pairs_files)
        assert (len_data == len_pair)
        # 获取完整文件名
        lens = len_data
        for i in range(lens):
            assert (data_files[i] == pairs_files[i])
            data_files[i] = path_data + '/'+ data_files[i]
            pairs_files[i] = path_pairs +'/'+ pairs_files[i]
        # 获取data和pairs
        data = FileIO.read_files(data_files)
        pairs = FileIO.read_pairs_from_files(pairs_files)
        # print(len(pairs),len(pairs[0]))
        # 返回
        return [data, pairs]

    # 读取一个文件，返回完整数据矩阵data、trace、result
    @staticmethod
    def read_a_file(file):
        file_obj = open(file)
        try:
            file_line = file_obj.readlines()
            data = []
            for line in file_line:
                line = line[0:len(line)-1]
                data_str = line.split(' ')
                data_int = [int(str) for str in data_str]
                data.append(data_int)

            trace = []
            result = []
            for n in data:
                trace.append((n[0:len(n)-1]))
                result.append(n[-1])

            return [data, trace, result]
        except Exception as ex:
            print(ex)
            return None
        finally:
            file_obj.close()

    # 读取一堆文件，返回完整数据矩阵data、trace、result
    @staticmethod
    def read_files(files):
        result = []
        for file in files:
            result.append(FileIO.read_a_file(file))
        # print(len(result),len(result[0][0]),len(result[0][1]),len(result[0][2]))
        return result

    # 读取一个文件，返回pairs矩阵
    @staticmethod
    def read_pairs_from_a_file(file):
        file_obj = open(file)
        try:
            # 读取两行
            file_line = file_obj.readlines()
            num = int(file_line[0])  # 第一行是数字，表示函数个数
            false_entity_str = file_line[1].split(' ')
            false_entity_int = [int(str) for str in false_entity_str]
            false_entity_int.sort()  # 第二行是一串数字，表示错误函数标号
            # 初始化数组matrux
            vector_0 = [0] * num
            matrux = [vector_0 for i in range(num)]
            # 获取pairs矩阵
            vector_1 = [1] * num
            length = len(false_entity_int)
            for i in range(length):
                matrux[false_entity_int[i]] = vector_1
                for j in range(length):
                    matrux[false_entity_int[i]][false_entity_int[j]] = 0
            # 返回
            return matrux
        except Exception as ex:
            print(ex)
            return None
        finally:
            file_obj.close()

    # 读取一堆文件，返回完整数据矩阵data、trace、result
    @staticmethod
    def read_pairs_from_files(files):
        result = []
        for file in files:
            result.append(FileIO.read_pairs_from_a_file(file))
            # print(len(result))
            # print(len(result[0]))
            # print(len(result),len(result[0]),len(result[0][0]))
        return result
