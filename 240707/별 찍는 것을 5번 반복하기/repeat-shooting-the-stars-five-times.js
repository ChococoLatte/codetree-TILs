const printFiveStars = ()=>{
    for(let i=0;i<10;i++){
        process.stdout.write('*')
    }
    process.stdout.write('\n');
}


for(let i=0;i<5;i++){
    printFiveStars();
}