package com.lec12.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/submit_post", method = RequestMethod.POST)
    public String submitPost(@RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("ufiles") List<MultipartFile> files,
                             Model model) {

        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setContents(contents);
        board.setRegid("testUser"); // 예시로 사용

        for (MultipartFile file : files) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();
            String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
            String uniqueName = UUID.randomUUID().toString().split("-")[0];
            String uploadFolder = "C:\\IT\\S3917_J11\\workspace_sts3\\uploads";
            String filePath = uploadFolder + "\\" + uniqueName + fileExtension;

            FileVO fvo = new FileVO();
            fvo.setFpath(filePath);
            fvo.setFsize(size);
            fvo.setOname(fileRealName);
            fvo.setSname(uniqueName + fileExtension);
            fvo.setBoard(board);

            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            board.getFiles().add(fvo);
        }

        boardService.saveBoard(board);

        return "lec12_file/file_upload_result";
    }
}
