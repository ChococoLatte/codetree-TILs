const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ");
const [n,m] = input.map(Number);

function printRectOne(n,m){
    for(let i=0;i<n;i++){
        let str = '';
        for(let j=0;j<m;j++){
            str+='1';
        }
        console.log(str);
    }
}

printRectOne(n,m);