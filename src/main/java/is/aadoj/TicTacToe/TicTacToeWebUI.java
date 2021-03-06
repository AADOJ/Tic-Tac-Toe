package is.aadoj.TicTacToe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import com.google.gson.Gson;
import is.aadoj.TicTacToe.TicTacToeException;
import is.aadoj.TicTacToe.Result;


public class TicTacToeWebUI implements SparkApplication {
    public static void main(String[] args){
        staticFileLocation("/public");
        SparkApplication tictactoeweb = new TicTacToeWebUI();
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }
        tictactoeweb.init(); 
    }

    public void init(){
        
        

        post(new Route("player/id"){

            @Override
            public Object handle(Request request, Response response){
                TicTacToe game = new TicTacToe();
                String jarray = request.queryParams("id");
                Gson gson = new Gson();
                int[] inputs = gson.fromJson(jarray, int[].class); 
                try{
                	game.insertArray(inputs);
                } catch (TicTacToeException ex){
                	System.out.println(ex.getMessage());
                    return ex.getMessage();
                }
                
                Result r;
                if (game.gameFinished()) r = new Result(true, game.whoWon(), 9);
                else r = new Result(false, 9, 9);
                System.out.println(gson.toJson(r));
                return gson.toJson(r);
                
            }
        });

		
        post(new Route("computer/id"){

            @Override
            public Object handle(Request request, Response response){
                TicTacToe game = new TicTacToe();
                String jarray = request.queryParams("id");
                Gson gson = new Gson();
                int[] inputs = gson.fromJson(jarray, int[].class); 
                try{
                	game.insertArray(inputs);
                } catch (TicTacToeException ex){
                	System.out.println(ex.getMessage());
                    return ex.getMessage();
                }
                int ComMove = 9;
                if(!game.gameFinished()) {
                	try{
                		ComMove = game.getComputerMove();
                		game.insertChar(ComMove);
                	} catch (TicTacToeException ex){
                		System.out.println(ex.getMessage());
                    	return ex.getMessage();
                	}
                }
                Result r;
                if (game.gameFinished()) r = new Result(true, game.whoWon(), ComMove);
                else r = new Result(false, 9, ComMove);
                System.out.println(gson.toJson(r));
                return gson.toJson(r);
                
            }
        });

        
    }
}