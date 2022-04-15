package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signuppane implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

	@FXML
	private TextField txtid;

	@FXML
	private PasswordField txtpw;

	@FXML
	private Button btnsignup;

	@FXML
	private Button btnback;

	@FXML
	private Label lblconfirm;

	@FXML
	private PasswordField txtpwcheck;

	@FXML
	private TextField txtname;

	@FXML
	private TextField txtemail;

	@FXML
	void back(ActionEvent event) {
		System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Login.instance.loadpage("/view/login/loginpane.fxml");
	}

	@FXML
	void signup(ActionEvent event) {
		String id = txtid.getText();
		String pw = txtpw.getText();
		String pwcheck = txtpwcheck.getText();
		String name = txtname.getText();
		String email = txtemail.getText();

		boolean result1 = MemberDao.memberDao.idcheck(id);

		// 아이디 중복체크
		if (result1) {
			lblconfirm.setText("ID 중복");
			return;
		}
		// 아이디 형식
		if (id.length() < 4 || id.length() > 10) {
			lblconfirm.setText("아이디 길이 문제 발생");
			return;
		}
		// 비밀번호 형식
		if (pw.length() < 4 || pw.length() > 10 || pwcheck.length() < 4 || pwcheck.length() > 10) {
			// 비밀번호가 너무 짧거나 길면 가입 X
			lblconfirm.setText("비밀번호의 길이 문제 발생");
			return;
		}
		// 비밀번호 체크
		if (!pw.equals(pwcheck)) {
			lblconfirm.setText("비밀번호가 일치하지 않습니다");
			return;
		}
		// 이메일 체크
		if (email.indexOf("@") == -1) { // 이메일에 @가 없으면
			lblconfirm.setText("올바르지 않은 이메일 양식");
			return;
		}

		Member member = new Member(0, id, pwcheck, name, email, email, 0);

		boolean result = MemberDao.memberDao.signup(member);
		if (result) {
			// 메시지창 출력 [alert]
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("알림");
			alert.setHeaderText("환영합니다");
			alert.setContentText("많은 이용 부탁드립니다");
			alert.showAndWait();

			// 화면 전환
			Login.instance.loadpage("/view/login/loginpane.fxml");
		} else {
			System.out.println("가입실패");
		}
	}
}
