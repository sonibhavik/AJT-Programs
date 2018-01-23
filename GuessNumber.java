import java.awt.*;
import java.awt.event.*;

public class GuessNumber extends Frame{
	Label l1 = new Label("The number is");
	TextField t1 = new TextField(10);
	Button generate = new Button("generate");
	Label l2 = new Label("Enter your guess");
	TextField t2 = new TextField(10);
	Label message = new Label("");
	int n,count=0;

	public GuessNumber(String title){
		//this.setTitle(title);

		super(title);
		this.addWindowListener(new MyWindowListener());
		this.setLayout(new FlowLayout());
		this.add(l1);
		this.add(t1);
		this.add(generate);
		this.add(l2);
		this.add(t2);
		this.add(message);
		generate.addMouseListener(new MyMouseListener(this));
		t2.addKeyListener(new MyKeyListener(this));
	}

	public static void main(String[] s){
		GuessNumber app1 = new GuessNumber("Guess the number");
		app1.setSize(300, 200);
		app1.setVisible(true);
	}

}

class MyMouseListener extends MouseAdapter{
	GuessNumber localRef;
	public MyMouseListener(GuessNumber t){
		localRef = t;
	}
	public void mouseClicked(MouseEvent me){
		int random = (int)(100*Math.random());
		localRef.n = random;
		localRef.t1.setText("**");
		localRef.t1.setEnabled(false);
		
	}

}

class MyKeyListener extends KeyAdapter{
	GuessNumber localRef;
	public MyKeyListener(GuessNumber t){
		localRef = t;
	}

	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_ENTER){
			localRef.count++;
			if(localRef.count<3)
			{
				int typedNum = Integer.parseInt(localRef.t2.getText());
			if(typedNum > localRef.n)
			{
				localRef.message.setText("Try Lower");
			} else if(typedNum < localRef.n){
				localRef.message.setText("Try Higher");
			} else{
				localRef.message.setText("You got it!");
			}
			}
			else{
				localRef.t2.setEnabled(false);
				localRef.l2.setText("Game Over!!!!!!!!!!!");
			}	
		}
	}
}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent we){
		System.exit(0);
	}
}