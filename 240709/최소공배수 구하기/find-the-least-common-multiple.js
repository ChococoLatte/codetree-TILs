const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ");
let [n,m] = input.map(Number);

function findGCD(n,m){
    for(let i=Math.min(n,m);i>0;i--){
        if(n%i === 0 && m%i === 0) return i;
    }
    return 1;
}

function findLCM(n,m){
    console.log(n*m/findGCD(n,m));
}

findLCM(n,m);