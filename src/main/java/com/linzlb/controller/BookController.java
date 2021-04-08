package com.linzlb.controller;

import javax.annotation.Resource;
import com.linzlb.dto.RequestDto;
import com.linzlb.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.linzlb.dao.BookDao;
import com.linzlb.entity.Book;
import java.util.List;

/**
 * Book控制类 增删查改demo
 * @author user
 * @GetMapping(value="xxx") 类似  @RequestMapping(value="xxx",method=RequestMethod.GET)
 * @PostMapping(value="xxx") 类似  @RequestMapping(value="xxx",method=RequestMethod.POST)
 */
@RestController
@RequestMapping("/book")
public class BookController {
 
    @Resource
    private BookDao bookDao;
     
    /**
     * 查询所有图书
     * @return
     */
    //,method = RequestMethod.POST, consumes = "application/json"
    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @RequestMapping(value="/list")
    public ResponseDto list(){
        List<Book> bookList = bookDao.findAll();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("000000");
        responseDto.setMsg("success");
        responseDto.setBody(bookList);
        return responseDto;
    }

    /**
     * 添加图书
     * @param requestDto
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto add(@RequestBody RequestDto<Book> requestDto){
        bookDao.save(requestDto.getBody());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("000000");
        responseDto.setMsg("success");
        return responseDto;
    }
     
    /**
     * 修改图书
     * @param requestDto
     * @return
     */
    @RequestMapping(value="/update",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto update(@RequestBody RequestDto<Book> requestDto){
        bookDao.save(requestDto.getBody());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("000000");
        responseDto.setMsg("success");
        return responseDto;
    }

     
    /**
     * 删除图书
     * @param requestDto
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto delete(@RequestBody RequestDto<Book> requestDto){
        bookDao.deleteById(requestDto.getBody().getId());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("000000");
        responseDto.setMsg("success");
        return responseDto;
    }

}