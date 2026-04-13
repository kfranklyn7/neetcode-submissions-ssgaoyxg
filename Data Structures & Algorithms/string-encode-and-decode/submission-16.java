class Solution {
    // to encode, we can likely use Stringbuilder to append all the strings before returning them

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String s : strs){
          result.append(s.length() + "#");
          result.append(s);
        }
        return result.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < str.length()){
            int numIndex = index;
            while(str.charAt(numIndex) != '#'){
                numIndex++;
            }
            int num = Integer.parseInt(str.substring(index,numIndex));
            System.out.println(str.substring(numIndex+1,numIndex + num +1));
            index = numIndex +1;
            numIndex = index + num;
            result.add(str.substring(index,numIndex));
            index = numIndex;
        }
        return result;
        }
       
    }


//Input: ["neet","code","love","you"]
//   4 # n e e t
//   0 1 2 3 4 5
//                
//Output:["neet","code","love","you"]

//Input: ["we","say",":","yes"]

//Output: ["we","say",":","yes"]


