package com.mahjong.server.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahjong.server.model.Room;
import com.mahjong.server.service.GameService;

@Controller
@RequestMapping(value="/web/game")
public class GameController {

  @Autowired
  private GameService gameService;

  @RequestMapping(value="/changeRoom", method=RequestMethod.GET)
  public String changeRoom(Model model) {
    List<Room> list=gameService.getRooms();
    list.get(1).setName("xxxx");
    return "";
  }

  @RequestMapping(value="/test/{id}", method=RequestMethod.GET)
  public String test(Model model, @PathVariable int id) {
    // Corp corp=corpManager.getCorpById(id);
    // model.addAttribute("corp", corp);
    // if(corp != null) {
    // model.addAttribute("nowNumber", corp.getMembers().size());
    // model.addAttribute("members", corp.getMembers());
    // }
    // return DETAIL;
    return null;
  }
}
