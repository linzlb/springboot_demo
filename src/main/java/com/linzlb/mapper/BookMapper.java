package com.linzlb.mapper;

import com.linzlb.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/25 14:41
 * @Function:
 */
@Component
@Mapper
public interface BookMapper {

    List<Book> selectAllBooks();
}
