import curves.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StlCurves{

    public static void main(String[] args){
		
		
		String name = "";
		Solid solid = new Solid();
		Curve cone = new ConeCurve();
		Curve mkSaddle = new MonkeySaddle();
		Curve hfSphere = new HalfSphere(20.0);
		Curve para = new HyperPara();
		CreateStlCurve curve = new CreateStlCurve();
		Scanner input = new Scanner(System.in);
		Curve[] list = {cone, mkSaddle, hfSphere, para};
		System.out.println("1. " + list[0].getName());
        System.out.println("2. " + list[1].getName());
		System.out.println("3. " + list[2].getName());
		System.out.println("4. " + list[3].getName());
		System.out.println("Which curve number do you want?: " );
		int inputNum = input.nextInt();
		
		if (0 > inputNum || 4 < inputNum) {
			System.out.println("Invalid number, no curve created.");
		}

		curve.createMatrix(list[inputNum-1]);
		solid = curve.createSolid(list[inputNum-1].getName());
		name = "c:\\temp\\"+list[inputNum-1].getName()+".stl";
		
		input.close();

		Path path = Paths.get(name);
		try {
			solid.toTextFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		System.out.println("Created C:\\temp\\" + list[inputNum-1].getName() + ".stl");

		
				
		


        




    }







}