package com.kosta.semi.ctl;

import org.springframework.stereotype.Controller;              //@Controller
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired; //@Autowired
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute; //@ModelAttribute	
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;  //@RequestMapping
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.semi.svc.BoardService;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;
import com.kosta.semi.vo.FileVO;

@Controller
public class BoardController  {
	
	@Autowired
	private BoardService boardService;
	
	
	
	@RequestMapping(value = "/board_insert", method = RequestMethod.POST)
	public String ctlBoardInsert(@ModelAttribute BoardVO bvo,
			//@RequestParam("ufile") MultipartFile file ) {
			@RequestParam("ufiles") List<MultipartFile> files ) {
		
		//-----------------------------------------------------------------------------------------
		//사용자파일명, 크기, 확장자, 시스템파일명(유니크)
		FileVO fvo = null;
		ArrayList<FileVO> fvoList = new  ArrayList<FileVO>();
		if (files != null) {			
			for(MultipartFile file : files) {
						fvo = new FileVO();
						String fileRealName 	= file.getOriginalFilename();
						long size 				= file.getSize();
						String fileExtension 	= fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
						String uniqueName 		= UUID.randomUUID().toString().split("-")[0];
						
						String uploadFolder = "C:\\IT\\S3917_J11\\workspace_sts3\\uploads";
						String filePath 	=  uploadFolder +"\\" + uniqueName + fileExtension;
						
						fvo.setFpath(filePath);   	//C:\\test\\upload\\45dfered.txt
						//fvo.setFseq(0);   											//시퀀스 nextval
						fvo.setFsize(size);
						fvo.setOname(fileRealName);
						//fvo.setSeq(1);												//실제 게시물 글번호 : 하드코딩
						fvo.setSname(uniqueName + fileExtension);						//45dfered.txt
						
						System.out.println(fvo.toString());
						
						//파일카피
						try {
							file.transferTo( new File(filePath) ); 
							fvoList.add(fvo);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
				} //e.o.for
			} //e.o.if
		//-----------------------------------------------------------------------------------------	
		
		int insertRows = boardService.svcBoardInsert(bvo, fvoList);
		return "redirect:/board_list";						//   /board_list
	}
	
	@RequestMapping(value = "/board_list")
	public String ctlBoardList(Model model){
		ArrayList<BoardVO> list = (ArrayList)boardService.svcBoardSelect();
		model.addAttribute("KEY_BOARDLIST", list);
		return "board/board_list";     				//   /  lec05_board/board_list  .jsp  
	}
	
	@RequestMapping(value = "/board_detail")
	public String ctlBoardDetail(Model model, @RequestParam("seq") int seq){
		//------------------------------------------------------
		//상세만 가져가고 ,댓글목록은 (REST)로 출력
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardVO bvo = boardService.svcBoardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		return "board/board_detail";						//   /   lec05_board/board_detail  .jsp
	}
	
	//댓글목록 : REST
	@RequestMapping(value = "/reply_list_rest" , method = RequestMethod.POST, produces = "application/json" )
	@ResponseBody 
	public ResponseEntity<ArrayList<ReplyVO>> ctlReplyListForRest(Model model
			, @RequestParam("seq") int seq){
		System.out.println(seq);
		
		ArrayList<ReplyVO> rlist = (ArrayList)boardService.svcReplySelect(seq);
		return new ResponseEntity<ArrayList<ReplyVO>>(rlist, HttpStatus.OK);	
	}
	
	//댓글등록 : REST
	@RequestMapping(value = "/reply_insert_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyInsertForRest(Model model
			, @ModelAttribute ReplyVO rvo){
		System.out.println(rvo.getReply());
		
		int res = boardService.svcReplyInsert(rvo);
		String msg = "입력에러";
		if(res > 0) {
			msg = "입력성공";
		}
		//return String.valueOf(res);	
		return String.valueOf(msg);
	}
	
	//댓글삭제 : REST
	@RequestMapping(value = "/reply_delete_rest" , method = RequestMethod.POST)
	@ResponseBody 
	public String ctlReplyDeleteForRest(Model model
			, @ModelAttribute ReplyVO rvo){
		System.out.println(rvo.getRseq());
		
		int deleteRows = boardService.svcReplyDelete(rvo.getRseq());
		String msg = "삭제에러";
		if(deleteRows > 0) {
			msg = "삭제성공";
		}
		//return String.valueOf(res);	
		return String.valueOf(msg);
	}
	
	@RequestMapping(value = "/board_update", method = RequestMethod.POST)
	public String ctlBoardUpdate(Model model, @ModelAttribute BoardVO bvo){
		int updateRows = boardService.svcBoardUpdate(bvo);
		//상세보기파라미터 : seq
		return "redirect:/board_detail?seq="+bvo.getSeq();						//   /board_detail?seq=3
	}
	
	@RequestMapping(value = "/board_delete", method = RequestMethod.POST)
	public String ctlBoardDel(Model model, @RequestParam("seq") int seq){
		int deleteRows = boardService.svcBoardDelete(seq);
		return "redirect:/board_list";											//   /board_list
	}
	
	
}
