function printN(N){
    let num = 1;
    for(let i=0;i<N;i++){
        for(let j=0;j<N;j++){
            if(num === 10) num = 1;
            process.stdout.write((num++)+" ");
        }
        process.stdout.write('\n');
    }
}

const fs = require("fs");
const N = Number(fs.readFileSync(0).toString().trim());
printN(N);