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

    /**
     * Get all sent information in a chat room
     *
     * @param roomTitle The room name the maintainer wants to get all the sent chat from
     * @return All texts from the chat room
     */
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

    /**
     * Send a text in a chat room
     * @param roomTitle The name of the chat room
     * @param userId Id of the user
     * @param chatText the text the user wants to send
     * @return The text the user wants to send to the chat room
     */
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

    /**
     * Clear all texts from the Math chat room (for maintainers use only)
     * @return blank
     */
    @RequestMapping(value = "clearMath", method = RequestMethod.GET)
    public ActionResult clearMath() {
        mathRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    /**
     * Clear all texts from the English chat room (for maintainers use only)
     * @return blank
     */
    @RequestMapping(value = "clearEnglish", method = RequestMethod.GET)
    public ActionResult clearEnglish() {
        englishRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    /**
     * Clear all texts from the Science chat room (for maintainers use only)
     * @return blank
     */
    @RequestMapping(value = "clearScience", method = RequestMethod.GET)
    public ActionResult clearScience() {
        scienceRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }

    /**
     * Clear all texts from the Elective chat room (for maintainers use only)
     * @return blank
     */
    @RequestMapping(value = "clearElective", method = RequestMethod.GET)
    public ActionResult clearElective() {
        electiveRoomDao.deleteAll();
        return ActionResult.genActionResultByOk();
    }
}
