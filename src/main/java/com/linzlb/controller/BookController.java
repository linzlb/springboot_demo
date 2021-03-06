package com.linzlb.controller;

import javax.annotation.Resource;
import com.linzlb.dto.RequestDto;
import com.linzlb.dto.ResponseDto;
import com.linzlb.mapper.BookMapper;
import com.linzlb.service.SendSMS;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.linzlb.dao.BookDao;
import com.linzlb.entity.Book;
import java.util.List;

/**
 * Book控制类 增删查改demo
 *  + 统一异常处理
 * @author user
 * @GetMapping(value="xxx") 类似  @RequestMapping(value="xxx",method=RequestMethod.GET)
 * @PostMapping(value="xxx") 类似  @RequestMapping(value="xxx",method=RequestMethod.POST)
 */
@Api(value="书本Controller", tags={"书本接口"})
@RestController
@RequestMapping("/book")
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookDao bookDao;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private SendSMS sendSMS;
     
    /**
     * 查询所有图书
     * @return
     */
    //,method = RequestMethod.POST, consumes = "application/json"

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = "/list" , method= {RequestMethod.GET} )
    public ResponseDto list(){
        sendSMS.asynSend();

        List<Book> bookList = bookDao.findAll();
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setCode("000000");
//        responseDto.setMsg("success");
//        responseDto.setBody(bookList);
//        return responseDto;
        return ResponseResultUtil.generateSuccessResult(bookList);
    }

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = "/listByMybatis" , method= {RequestMethod.GET} )
    public ResponseDto listByMybatis(){

        List<Book> bookList = bookMapper.selectAllBooks();
        return ResponseResultUtil.generateSuccessResult(bookList);
    }


    /**
     * 添加图书
     * @param requestDto
     * @return
     */
    @ApiOperation(value = "添加图书", notes = "添加图书")
    @RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto add(@RequestBody RequestDto<Book> requestDto){
        bookDao.save(requestDto.getBody());
        return ResponseResultUtil.generateSuccessResult(null);
    }
     
    /**
     * 修改图书
     * @param requestDto
     * @return
     */
    @ApiOperation(value = "修改图书", notes = "修改图书")
    @RequestMapping(value="/update",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto update(@RequestBody RequestDto<Book> requestDto){
        bookDao.save(requestDto.getBody());
        return ResponseResultUtil.generateSuccessResult(null);
    }

     
    /**
     * 删除图书
     * @param requestDto
     * @return
     */
    @ApiOperation(value = "删除图书", notes = "删除图书")
    @RequestMapping(value="/delete",method=RequestMethod.POST,consumes = "application/json")
    public ResponseDto delete(@RequestBody RequestDto<Book> requestDto){
        bookDao.deleteById(requestDto.getBody().getId());
        return ResponseResultUtil.generateSuccessResult(null);
    }

}