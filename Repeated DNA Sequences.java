
//brute force- tc-O(10*n) sc- 10n
// class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {

//         HashSet<String> allSeq = new HashSet<>();
//         HashSet<String> result = new HashSet<>();

//         for(int i = 0; i < s.length()-9; i++){
//             String sub = s.substring(i, i+10);
//             if(!allSeq.contains(sub)){
//                 allSeq.add(sub);
//             }else{
//                 result.add(sub);
//             }
//         }

//         return new ArrayList<>(result);
        
//     }
// }

//using robin carps tc- O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('T', 2);
        map.put('C', 3);
        map.put('G', 4);

        long hash = 0;
        long posFac = (long)Math.pow(4, 10);

        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if(i >= 10){
                char out = s.charAt(i-10);
                hash = hash - (posFac * map.get(out));
            }

            if(allSeq.contains(hash)){
                result.add(s.substring(i-9, i+1));
            }else{
                allSeq.add(hash);
            }
        }

        return new ArrayList<>(result);
        
    }
}

