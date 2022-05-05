import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css']
})
export class PaiementComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.invokeStripe();
  }
  makePayment(amount:any){
const paymenthandler = (<any>window).StripeCheckout.configure({
  key:
  'pk_test_51KvVjZElOXZEDQu8a0J8rOx6CBNoZzLvwK38CvqrNghLrexrQkQnWETgfUvXaOo2wwgn2jJQ2wDG26UUcXxHbK6i00OOXrQkam',
  locale:'auto',
  token: function(stripeToken: any){
    console.log(stripeToken.card);
    alert('Stripe toker generated!');
  },
});
paymenthandler.open({
  name:'technical Adda',
  description:'4 Products Added',
  amount :  amount *100,
});
  }
invokeStripe(){
  if(!window.document.getElementById('stripe-stripe')){
    const script=window.document.createElement("script");
    script.id='script-script';
    script.type='text/javascript';
    script.src="";
    window.document.body.appendChild(script);
  }
}
}
