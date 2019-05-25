package com.hhs.studybook.controller;

import com.hhs.studybook.dao.ElectiveRoomDao;
import com.hhs.studybook.dao.EnglishRoomDao;
import com.hhs.studybook.dao.MathRoomDao;
import com.hhs.studybook.dao.ScienceRoomDao;
import com.hhs.studybook.entity.ElectiveChatRoom;
import com.hhs.studybook.entity.EnglishChatRoom;
import com.hhs.studybook.entity.MathChatRoom;
import com.hhs.studybook.entity.ScienceChatRoom;
import com.hhs.studybook.util.ActionResult;
import com.hhs.studybook.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ChatRoom {

    @Autowired
    private ElectiveRoomDao electiveRoomDao;

    @Autowired
    private EnglishRoomDao englishRoomDao;

    @Autowired
    private MathRoomDao mathRoomDao;

    @Autowired
    private ScienceRoomDao scienceRoomDao;

    @RequestMapping(value = "getAllChats", method = RequestMethod.POST)
    public ActionResult getAllChats(@RequestParam("roomTitle") String roomTitle) {
        List result = null;
        if (roomTitle.equals("Math")) {
            result = mathRoomDao.findAll();
        } else if (roomTitle.equals("English")) {
            result = englishRoomDao.findAll();
        } else if (roomTitle.equals("Elective")) {
            result = electiveRoomDao.findAll();
        } else if (roomTitle.equals("Science")) {
            result = scienceRoomDao.findAll();
        }
        return ActionResult.genActionResult(ResultCode.CODE_OK, result);
    }

    @RequestMapping(value = "addChat", method = RequestMethod.POST)
    public ActionResult addChat(@RequestParam("roomTitle") String roomTitle, @RequestParam("userId") Integer userId,
                                @RequestParam("chatText") String chatText) {

        if (roomTitle.equals("Math")) {
            mathRoomDao.saveAndFlush(new MathChatRoom(new Date().toString(), userId, chatText));
        } else if (roomTitle.equals("English")) {
            englishRoomDao.saveAndFlush(new EnglishChatRoom(new Date().toString(), userId, chatText));
        } else if (roomTitle.equals("Elective")) {
            electiveRoomDao.saveAndFlush(new ElectiveChatRoom(new Date().toString(), userId, chatText));
        } else if (roomTitle.equals("Science")) {
            scienceRoomDao.saveAndFlush(new ScienceChatRoom(new Date().toString(), userId, chatText));
        }

        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "clearMath", method = RequestMethod.GET)
    public ActionResult clearMath() {
        mathRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "clearEnglish", method = RequestMethod.GET)
    public ActionResult clearEnglish() {
        englishRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "clearScience", method = RequestMethod.GET)
    public ActionResult clearScience() {
        scienceRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    @RequestMapping(value = "clearElective", method = RequestMethod.GET)
    public ActionResult clearElective() {
        electiveRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }
}
