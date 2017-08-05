package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @Override
    public void save(Movie movie){
        movieMapper.save(movie);
    }

    @Override
    public void delById(Integer id){
        movieMapper.delById(id);
    }

    @Override
    public  void editById(Integer id) {
        movieMapper.editById(id);
    }

    @Override
    public Movie findById(Integer id) {
        return movieMapper.findById(id);
    }

    @Override
    public void update(Movie movie) {
        movieMapper.update(movie);
    }

    @Override
    public PageInfo<Movie> PageByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo, 10);
        List<Movie> movieList = movieMapper.findAll();
        return new PageInfo<>(movieList);
    }


}
