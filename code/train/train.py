# /user/bin/env python
# -*-coding:utf-8-*-
from code.ranking.ranking_boost import RankBoost
from code.train.data_statistics import DataStatistics, BoostFeature
from code.train.file_io import FileIO


class Train:
    # 训练数据
    # 输入两个文件夹，一个是路径数组，一个是对应的pairs
    # 输出feature
    def start(self,path1,path2):
        [data, pairs] = FileIO.read(path1,path2);
        features = DataStatistics.init_feature()
        vectors = DataStatistics.get_veators_from_programs(data)
        distribution = DataStatistics.merge(pairs)
        a = RankBoost.boost(vectors,features,distribution)

        boost_feature = BoostFeature.__init__(features,a)

        return boost_feature

