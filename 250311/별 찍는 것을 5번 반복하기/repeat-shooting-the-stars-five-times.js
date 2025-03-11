const printFiveStars = ()=>{
    for(let i=0;i<5;i++){
        for(let j=0;j<10;j++){
            process.stdout.write("*");
        }
        process.stdout.write('\n');
    }
}

printFiveStars();