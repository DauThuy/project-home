package com.example.demo.model.mapper;

import java.util.Date;

import com.example.demo.entity.Account;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.InfoCreateUser;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class AccountMapper {
    public static UserDto toUserDto(Account account) {
        UserDto userDtoMapper = new UserDto();
        userDtoMapper.setAccountName(account.getAccountName());
        userDtoMapper.setEmailAddress(account.getEmailAddress());
        userDtoMapper.setRoleId(account.getAccountStatus());
        return userDtoMapper;
    }

    public static InfoCreateUser toInfoCreateUserDto(Account account) {
        Date now = new Date();
        InfoCreateUser infoCreateUser = new InfoCreateUser();
        infoCreateUser.setAccountId(account.getAccountId());
        infoCreateUser.setAccountName(account.getAccountName());
        infoCreateUser.setAccountPassword(account.getAccountPassword());
        infoCreateUser.setEmailAddress(account.getEmailAddress());
        infoCreateUser.setAccountImage(account.getAccountImage());
        infoCreateUser.setAccountStatus(account.getAccountStatus());
        infoCreateUser.setApprovalDate(now);
        infoCreateUser.setDateCreated(now);
        infoCreateUser.setDateModified(now);
        infoCreateUser.setRoleId(account.getRoleId());
        return infoCreateUser;
    }

    public static Account toUser(CreateUserReq req) {
        Account user = new Account();
        user.setAccountId(user.getAccountId());
        user.setAccountName(req.getAccountName());
        user.setEmailAddress(req.getEmailAddress());
        String hash = BCrypt.hashpw(req.getAccountPassword(), BCrypt.gensalt(12));
        user.setAccountPassword(hash);
        return user;
    }

    public static Account toUser(UpdateUserReq req, int id) {
        Account user = new Account();
        user.setAccountName(req.getAccountName());
        user.setEmailAddress(req.getEmailAddress());
        return user;
    }
}