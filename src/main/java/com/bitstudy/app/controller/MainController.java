package com.bitstudy.app.controller;

import com.bitstudy.app.dao.ArticleDao;
import com.bitstudy.app.dao.CommentDao;
import com.bitstudy.app.dao.FollowDao;
import com.bitstudy.app.domain.ArticleDto;
import com.bitstudy.app.domain.CommentCountDto;
import com.bitstudy.app.domain.CommentDto;
import com.bitstudy.app.domain.UserDto;
import com.bitstudy.app.service.ArticleService;
import com.bitstudy.app.service.CommentService;
import com.bitstudy.app.service.FollowService;
import com.bitstudy.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    @Autowired
    FollowService followService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;



    /*컨트롤러 할 일
0. 사용자이미지/댓글수/하트수 업데이트하기 (서영씨 하면 받고 설명해주기)❤️
1. 로그인한 아이디의 팔로잉 아이디값을 찾아서 게시글 보여주기 (이거 좀 오래걸려요 작업이 안 돼있어요)❤️
2. 게시글 하트 눌럿는지 안 눌렀는지 확인 후 하트색 채울지 뺄지? (뷰파일에서 포이치 안에서 하면 됩니다)❤️
3. 게시글에 아이디/사용자이미지(안함)/이름/게시글사진/댓글수/하트수/게시글내용 보여주기(이것도 뷰파일에서 찍어 주면 됩니다 포이치 쓰고)❤️
3-1) 하트누르면 인설트 혹은 딜리트 해주기(ajax)
4.  댓글버튼 누르면 팝업창 뜨고 (ajax 쓸거임 어떻게 쓸거냐 게시물 번호 받아와서 일단 부모꺼만 찍어주기)
4-0. 대댓글 찍어주기 이것또한 ajax 입니다 ~(대댓글 더보기 누르면 거기에 있는 게시물 번호와 부모 게실물 번호 들고아서 조회해서 찍어주기)
4-1. 댓글 등록 누르면 댓글 등록되고(부모댓글 등록입니다. 이것또한 ajax)
5.  댓글작성자가 로그인 한 유저랑 같으면 삭제/수정할 수 있게 해주기
6.  대댓글 작성하기(ajax 적는 칸 부모 댓글 번호들고가서 등록하면 됩니다 간단하죠)ㅎ

*/

//1. 로그인한 아이디의 팔로잉 아이디값을 찾아서 게시글 보여주기
//순서 로그인 아이디 값 찾아와 팔로잉 값 찾아서 근데 중요한게 맵퍼에서 포이치 돌릴게 있어요.

    // 가장 먼저 해야 할일 매서드 컨트롤러 달아주기
    // 뷰파일 바로 보여주는 매서드 보여주기 (바로 보여주는건 get 방식이라는 겁니다)

    //메인페이지 보여주기
    @GetMapping("/mainPage")
    public String mainPage (HttpServletRequest request,Model m, String user, ArticleDto articleDto){
    //위에 세션 쓸거니깐 매개변수 적기
        //세션 만들고
        HttpSession session = request.getSession();

//        session.setAttribute("id","나상민"); //임시로 해둔거임
        // 아이디 값 임시로 하나 넣기 그리고 sout 찍어서 잘 들어깄는지 확인
        String id = (String) session.getAttribute("id");
        if (id ==null){
            return "redirect:/";
        }

        // 팔로우한 리스트 찾아오기
        // 팔로우한 리스트 담긴 거 찾아서 받을 타입 확인한 후에 담아서 저장하기.
        List<String> Following_id = followService.followerList(id);
        System.out.println("Following_id : " + Following_id);
        //['park1234',  'sung1009', 'gugu9999']



//        String test = "'park1234', 'sung1009', 'gugu9999'";

        Map map = new HashMap();
        map.put("user_id",id);
        map.put("Following_id",Following_id);
//        map.put("Following_id",test);


        List<ArticleDto> list = articleService.main_article(map);

        System.out.println("list : " + list);

        //모델에 담아보세요
        m.addAttribute("list",list);


    return "instagram";

    }


//2. 게시글 하트 눌럿는지 안 눌렀는지 확인 후 하트색 채울지 뺄지? (뷰파일에서 포이치 안에서 하면 됩니다)
// 하기위해서 조인을했죠 ?? 그값이 null이면 원래색 null아니면 빨간색 즉 뷰파일에서 만져야함.



    @PutMapping("/heart/modify/{A_seqno}")
    @ResponseBody
    public ResponseEntity<String> heartClick(@PathVariable Integer A_seqno, HttpSession session){
        try {
//            System.out.println("일단 넘어는 왔어요");
            String id = (String) session.getAttribute("id");

            Integer test2Result= articleService.heart_modify(id,A_seqno);
//            System.out.println(test2Result);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");

            if (test2Result == 1){
                return new ResponseEntity<String>("추가",responseHeader, HttpStatus.OK);
            }
            else if(test2Result == 0){
                return new ResponseEntity<String>("취소",responseHeader,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("로그인 후 이용해주세요.",responseHeader,HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }

    };



//댓글 모두보기, 댓글 아이콘 누르면 댓글창이 나타날거임
//그 댓글 창안에 그 게시글의 부모 댓글 찍어주기
@GetMapping("/comment/{A_seqno}")
@ResponseBody
    //댓글 모두 보기
    public ResponseEntity<List<CommentDto>> commentList(@PathVariable Integer A_seqno){

    try {
        // 댓글 들고오기 하고 밑에 담아서 넘겨주기
        List<CommentDto> commentList =commentService.comment_user(A_seqno);
        System.out.println("여기에요:2222 "+ commentList);

        return new ResponseEntity<List<CommentDto>> (commentList, HttpStatus.OK);// 200

    } catch (Exception e) {
//            throw new RuntimeException(e);
        e.printStackTrace();
        return new ResponseEntity<List<CommentDto>> (HttpStatus.BAD_REQUEST);// 400
    }
}

    @GetMapping("/comment/children/{A_seqno}")
    @ResponseBody
    //댓글 모두 보기
    public ResponseEntity<List<CommentDto>> childrenList(@PathVariable Integer A_seqno,Integer group){
        try {
//            System.out.println("자식댓글 가지고 옴");
//            System.out.println(A_seqno);
//            System.out.println(group);
            // 댓글 들고오기 하고 밑에 담아서 넘겨주기
            List<CommentDto> childrenList =commentService.comment_c(A_seqno,group);
//            System.out.println(childrenList);

            return new ResponseEntity<List<CommentDto>> (childrenList, HttpStatus.OK);// 200

        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>> (HttpStatus.BAD_REQUEST);// 400
        }
    }

    @DeleteMapping("/comment/{c_seqno}")
    @ResponseBody
    //댓글 모두 보기
    public ResponseEntity<String> deleteComment(@PathVariable Integer c_seqno,HttpSession session){
        try {
            String id = (String)session.getAttribute("id");
//            System.out.println("삭제하러옴");
            System.out.println(c_seqno);


            CommentDto commentDto = commentService.selectComment(c_seqno);
//            System.out.println("여기에요: "+ commentDto.getC_class());
//            System.out.println("여기에요: "+ commentDto.getC_group_num());
            if (commentDto.getC_class() == 0){
//                System.out.println("if 문 들어왔음!!!");
                commentService.parentdelete(commentDto.getFK_A_seqno(),commentDto.getC_group_num());
            }
            else {commentService.comment_delete(c_seqno,id);}

            CommentCountDto commentCountDto = commentService.countOne(commentDto.getFK_A_seqno());

            if (commentCountDto.getFK_A_seqno()==null){
                commentCountDto.setC_count(0);
                commentCountDto.setFK_A_seqno(commentDto.getFK_A_seqno());
            }

            articleService.commentCountUpdate(commentCountDto);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");


            return new ResponseEntity<String> ("삭제했습니다",responseHeader, HttpStatus.OK);// 200


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }
    }

    @PostMapping("/comment/")
    @ResponseBody
    public ResponseEntity<String> insertComment(String text, Integer A_seqno,HttpSession session){
        try {
            String id = (String)session.getAttribute("id");
//            System.out.println("넘어는 왔어");
//            System.out.println(text);
//            System.out.println(A_seqno);

            CommentDto commentDto = new CommentDto();
            commentDto.setC_class(0);
            commentDto.setC_txt(text);
            commentDto.setC_writer(id);
            commentDto.setFK_A_seqno(A_seqno);
            Integer group = commentService.getGroup(A_seqno);
            if (group == null){group = 0;}
            else {group += 1;}
            // 이거해줄려고 최신꺼 잡아와야함. 있던 번호에 젤 위에꺼 그룹번호 입니다.(보내줄거 모임 번호 보내서 )
            commentDto.setC_group_num(group);

            commentService.comment_insert(commentDto);
            CommentCountDto commentCountDto = commentService.countOne(A_seqno);
            articleService.commentCountUpdate(commentCountDto);


            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");


            return new ResponseEntity<String> ("댓글이 등록 되었습니다.",responseHeader, HttpStatus.OK);// 200



        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }
    }

    @PostMapping("/comment/children/")
    @ResponseBody
    public ResponseEntity<String> childrenComment(String text, Integer A_seqno,HttpSession session,Integer group){
        try {
            String id = (String)session.getAttribute("id");
//            System.out.println("넘어는 왔어");
//            System.out.println(text);
//            System.out.println(A_seqno);
//            System.out.println(group);

            CommentDto commentDto = new CommentDto();
            commentDto.setC_class(1);
            commentDto.setC_txt(text);
            commentDto.setC_writer(id);
            commentDto.setFK_A_seqno(A_seqno);
            commentDto.setC_group_num(group);

            commentService.comment_insert(commentDto);

            CommentCountDto commentCountDto = commentService.countOne(A_seqno);
            articleService.commentCountUpdate(commentCountDto);

            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.add("content-type","text/html; charset=UTF-8");


            return new ResponseEntity<String> ("댓글이 등록 되었습니다.",responseHeader, HttpStatus.OK);// 200



        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);// 400
        }
    }


};





