package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * Created by fankay on 2017/7/14.
 */
public interface MovieMapper {

    List<Movie> findAll();

    void save(Movie movie);

    void delById(Integer id);

    void editById(Integer id);

    Movie findById(Integer id);

    void update(Movie movie);


}
