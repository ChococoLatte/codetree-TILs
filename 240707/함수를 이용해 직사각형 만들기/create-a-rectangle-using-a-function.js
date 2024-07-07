function printRect(n,m) {
    for(let i=0;i<n;i++){
        let s = '';
        for(let j=0;j<m;j++){
           s+='1';
        }
        console.log(s);
    }
};

const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ");
let [n,m] = input.map(Number);
printRect(n,m);