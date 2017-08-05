package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by fankay on 2017/7/14.
 */
public interface MovieService {

    List<Movie> findAll();
    void save(Movie movie);

    void delById(Integer id);

    void editById(Integer id);

    Movie findById(Integer id);

    void update(Movie movie);

    PageInfo<Movie> PageByPageNo(Integer pageNo);
}
