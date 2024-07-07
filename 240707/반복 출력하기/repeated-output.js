const printN = (N)=>{
    for(let i=0;i<N;i++){
        console.log('12345^&*()_');
    }
}

const fs = require("fs");
let N = Number(fs.readFileSync(0).toString().trim());
printN(N);