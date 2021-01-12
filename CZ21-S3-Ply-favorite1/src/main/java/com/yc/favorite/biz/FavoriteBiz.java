package com.yc.favorite.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagFavoriteMapper;
import com.yc.favorite.dao.TagMapper;

@Service
@Transactional
public class FavoriteBiz {

	@Resource
	private TagMapper tm;
	
	@Resource
	private FavoriteMapper fm;
	
	@Resource
	private TagFavoriteMapper tfm;
	
	public void addFavorite(Favorite f) {
		
		fm.insert(f);
		String[] tags = f.getFtags().split("[,;:，；：]");
		for(String tag : tags) {
			Tag t = new Tag();
			if(tm.updataCountByName(tag) == 0) {
				t.setTname(tag);
				t.setTcount(1L);
				tm.insert(t);
			} else {
				//
				t = tm.selectByName(tag);
			}
			tfm.insert(t.getTid(), f.getFid());
		}
	}
}
