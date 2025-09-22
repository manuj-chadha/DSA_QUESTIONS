class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder[] rows=new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            rows[j] = new StringBuilder();
        }

        int i=0;
        boolean goingDown=false;

        int index=0;
        while(i<s.length()){
            rows[index].append(s.charAt(i));
            if(index==0 || index==numRows-1) goingDown=!goingDown;
            index+=goingDown? 1: -1;

            i++;
        }
        for(int a=1;a<numRows;a++){
            rows[0].append(rows[a]);
        }
        return rows[0].toString();
    }
}