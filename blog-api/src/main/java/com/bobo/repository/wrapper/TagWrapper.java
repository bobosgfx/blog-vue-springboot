package com.bobo.repository.wrapper;

import java.util.List;

import com.bobo.vo.TagVO;

public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
