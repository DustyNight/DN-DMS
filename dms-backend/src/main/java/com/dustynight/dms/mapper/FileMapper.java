package com.dustynight.dms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dustynight.dms.model.FileModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: FileMapper
 * @description: TODO
 * @author: DustyNight
 * @date: 4/11/2021
 **/
@Mapper
public interface FileMapper extends BaseMapper<FileModel> {
}
