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
		System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
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

		// ���̵� �ߺ�üũ
		if (result1) {
			lblconfirm.setText("ID �ߺ�");
			return;
		}
		// ���̵� ����
		if (id.length() < 4 || id.length() > 10) {
			lblconfirm.setText("���̵� ���� ���� �߻�");
			return;
		}
		// ��й�ȣ ����
		if (pw.length() < 4 || pw.length() > 10 || pwcheck.length() < 4 || pwcheck.length() > 10) {
			// ��й�ȣ�� �ʹ� ª�ų� ��� ���� X
			lblconfirm.setText("��й�ȣ�� ���� ���� �߻�");
			return;
		}
		// ��й�ȣ üũ
		if (!pw.equals(pwcheck)) {
			lblconfirm.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			return;
		}
		// �̸��� üũ
		if (email.indexOf("@") == -1) { // �̸��Ͽ� @�� ������
			lblconfirm.setText("�ùٸ��� ���� �̸��� ���");
			return;
		}

		Member member = new Member(0, id, pwcheck, name, email, email, 0);

		boolean result = MemberDao.memberDao.signup(member);
		if (result) {
			// �޽���â ��� [alert]
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("�˸�");
			alert.setHeaderText("ȯ���մϴ�");
			alert.setContentText("���� �̿� ��Ź�帳�ϴ�");
			alert.showAndWait();

			// ȭ�� ��ȯ
			Login.instance.loadpage("/view/login/loginpane.fxml");
		} else {
			System.out.println("���Խ���");
		}
	}
}
