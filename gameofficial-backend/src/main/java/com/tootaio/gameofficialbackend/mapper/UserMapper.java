package com.tootaio.gameofficialbackend.mapper;

import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.entity.auth.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM account WHERE username = #{text} OR email = #{text}")
    Account findAccountByUsernameOrEmail(String text);

    @Select("SELECT * FROM account WHERE username = #{text} OR email = #{text}")
    UserAccount findUserAccountByUsernameOrEmail(String text);

    @Select("SELECT * FROM account WHERE email = #{email}")
    Account findAccountByEmail(String email);

    @Select("SELECT * FROM account WHERE username = #{username}")
    Account findAccountByUsername(String username);

    @Insert("INSERT INTO account (username, password, email, roleId) VALUES (#{username}, #{password}, #{email}, 1)")
    int createAccount(String username, String password, String email);

    @Update("UPDATE account SET password = #{password} WHERE email = ${email}")
    int resetPasswordByEmail(String password, String email);
}
