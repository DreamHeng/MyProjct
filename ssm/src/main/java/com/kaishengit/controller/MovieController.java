package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by fankay on 2017/7/14.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String list(@RequestParam(required = false, defaultValue = "1", name = "p") Integer pageNo,Model model) {
       PageInfo<Movie> pageInfo = movieService.PageByPageNo(pageNo);
       model.addAttribute("page", pageInfo);
        // / model.addAttribute("movieList",movieService.findAll());
        return "movie/list";
    }


    @GetMapping("/new")
    public String newMovie(){
        return "movie/new";
    }

    /**
     * 添加新电影
     * @return
     */
    @PostMapping("/new")
    public String saveMovie(Movie movie , RedirectAttributes redirectAttributes){
        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/movie";
    }

    /**
     * 删除
     */
    @GetMapping("/{id:\\d+}/del")
    public String deleteMovieById(@PathVariable Integer id , RedirectAttributes redirectAttributes){
        movieService.delById(id);
        redirectAttributes.addFlashAttribute("message","刪除成功");
        return "redirect:/movie";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String editById(@PathVariable Integer id, Model model){
        //根据ID查找movie
        Movie movie = movieService.findById(id);
        //将movie的对象传入jsp
        model.addAttribute(movie);
        return "movie/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editMovie(Movie movie, RedirectAttributes redirectAttributes){
        movieService.update(movie);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/movie";
    }

}
