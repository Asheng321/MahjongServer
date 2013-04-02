package com.mahjong.server.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahjong.server.client.test.MinaClientTest;
import com.mahjong.server.model.Player;
import com.mahjong.server.model.Room;
import com.mahjong.server.model.User;
import com.mahjong.server.service.GameService;
import com.mahjong.server.service.OnlineService;
import com.mahjong.server.service.UserService;

/**
 * 游戏控制类，主要写一些对服务器功能进行测试的接口
 * 
 * @author Simple
 * @date 2013-4-1 下午06:46:26
 * @Description TODO
 */
@Controller
@RequestMapping(value="/web/game")
public class GameController {

  @Autowired
  private MinaClientTest minaClientTest;

  @Autowired
  private GameService gameService;

  @Autowired
  private OnlineService onlineService;

  @Autowired
  private UserService userService;

  @RequestMapping(value="/_login", method=RequestMethod.GET)
  public String _login(Model model) {
    return "login";
  }

  @RequestMapping(value="/_register", method=RequestMethod.GET)
  public String _register(Model model) {
    return "register";
  }

  @RequestMapping(value="/changeRoomName", method=RequestMethod.GET)
  public String changeRoomName(Model model) {
    List<Room> list=gameService.getRooms();
    list.get(1).setName("xxxx");
    return "main";
  }

  @RequestMapping(value="/onlinePlayerList", method=RequestMethod.GET)
  public String onlinePlayerList(Model model) {
    List<Player> list=onlineService.getAllOnlinePlayer();
    model.addAttribute("list", list);
    return "onlinePlayerList";
  }

  @RequestMapping(value="/userList", method=RequestMethod.GET)
  public String userList(Model model) {
    List<User> list=userService.getAllUser();
    model.addAttribute("list", list);
    return "userList";
  }

  @RequestMapping(value="/roomList", method=RequestMethod.GET)
  public String roomList(Model model) {
    List<Room> list=gameService.getRooms();
    model.addAttribute("list", list);
    return "roomList";
  }

  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String register(Model model, HttpServletRequest req) {
    String username=req.getParameter("username");
    String password=req.getParameter("password");
    String mobileNum=req.getParameter("mobileNum");
    minaClientTest.register(username, password, mobileNum);
    return "login";
  }

  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String login(Model model, HttpServletRequest req) {
    String username=req.getParameter("username");
    String password=req.getParameter("password");
    minaClientTest.login(username, password);
    return "main";
  }
  // @RequestMapping(value="/test/{id}", method=RequestMethod.GET)
  // public String test(Model model, @PathVariable int id) {
  // // Corp corp=corpManager.getCorpById(id);
  // // model.addAttribute("corp", corp);
  // // if(corp != null) {
  // // model.addAttribute("nowNumber", corp.getMembers().size());
  // // model.addAttribute("members", corp.getMembers());
  // // }
  // // return DETAIL;
  // return null;
  // }
}
