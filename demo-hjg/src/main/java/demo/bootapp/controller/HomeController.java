package demo.bootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.bootapp.model.Tile;
import demo.bootapp.repository.TileRepository;

@RestController
public class HomeController {
	@Autowired
	TileRepository tileRepository;
	@RequestMapping("/home")
	List<Tile> get(){
		return tileRepository.getTiles();
	}
}
