
// Math property
console.log(Math.PI);

// Math method
// abs: 절댓값
console.log(Math.abs(-10));                     
console.log(Math.abs('-10'));                   
console.log(Math.abs(''));                     
console.log(Math.abs([]));                      
console.log(Math.abs(null));                    
console.log(Math.abs(undefined));               
console.log(Math.abs({}));                      
console.log(Math.abs('math'));                 
console.log(Math.abs());                       
console.log('--------------------');

// round: 반올림
console.log(Math.round(10.1));                  
console.log(Math.round(10.9));                  
console.log(Math.round(-10.1));                 
console.log(Math.round(-10.9));                 
console.log(Math.round(10));                    
console.log(Math.round());                      
console.log('--------------------');

// ceil: 올림
console.log(Math.ceil(10.1));                 
console.log(Math.ceil(10.9));                 
console.log(Math.ceil(-10.1));                
console.log(Math.ceil(-10.9));                
console.log(Math.ceil(10));                   
console.log(Math.ceil());                     
console.log('--------------------');

// floor: 버림
console.log(Math.floor(10.1));                
console.log(Math.floor(10.9));                
console.log(Math.floor(-10.1));               
console.log(Math.floor(-10.9));               
console.log(Math.floor(10));                  
console.log(Math.floor());                    
console.log('--------------------');

// sqrt: 양의 제곱근
console.log(Math.sqrt(4));                    
console.log(Math.sqrt(-4));                   
console.log(Math.sqrt(2));                    
console.log(Math.sqrt(1));                    
console.log(Math.sqrt(0));                    
console.log(Math.sqrt());                     
console.log('--------------------');

// random: 난수
console.log(Math.random());               
const random = Math.floor((Math.random() * 100) + 1);
console.log(random);
console.log('--------------------');

// pow: 거듭 제곱
console.log(Math.pow(2, 2));                 
console.log(Math.pow(2, -2));                

console.log(2 ** 2);                         
console.log(2 ** -2);                        
console.log('--------------------');

// max: 최댓값
console.log(Math.max(10));                   
console.log(Math.max(10, 20));               
console.log(Math.max(10, 20, 30));           
console.log(Math.max());                     
console.log('--------------------');          

// min: 최솟값
console.log(Math.min(10));                   
console.log(Math.min(10, 20));               
console.log(Math.min(10, 20, 30));           
console.log(Math.min());                     
console.log('--------------------');      