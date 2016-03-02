package week1;

public class ReduceFilePath {

	public static void main(String[] args) {
			ReduceFilePath path=new ReduceFilePath();
			String[] test={"/", "/srv/../", "/srv/www/htdocs/wtf/", "/srv/www/htdocs/wtf",
			"/srv/./././././", "/etc//wtf/", "/etc/../etc/../etc/../", "//////////////", "/../"};
			
			for(int i=0; i<test.length;i++){
				
				System.out.println(path.reduceFilePath(test[i]));
			}
	}
	
	/*Every .. means that we have to go one directory back
	Every . means that we are staying in the same directory
	Every extra / is unnecessary
	Always remove the last /*/
		public String reduceFilePath(String path){
			StringBuilder result=new StringBuilder();
			//split by /
			String[] words=path.split("/");
			//reverse words - we are going backward
			for (int i=0; i<words.length; i++)
			{
				words[i]=new StringBuffer(words[i]).reverse().toString();		
			}
			
			for(int i= words.length-1; i>0; i--){
				//if .. decrease i (+= next element)
				if(words[i].equals("..")){
					i-=1;
				}
				//if '' or '.' do nothing i will decrease on next iteration
				else if (words[i].equals("")||words[i].equals(".")){
					;
				}else{
					result.append(words[i]+"/");
				}
			}
			if(result.length()==0){
				result.append("/");
			}	
			return result.reverse().toString();
		}
	
}