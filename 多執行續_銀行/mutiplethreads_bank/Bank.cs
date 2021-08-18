using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mutiplethreads_bank
{
    class Bank
    {
        public int money  = 10000;
        public int outlay  = 0;
        public int income  = 10000;
        private bool _stop = false;
        public bool stop
        {
            get {
                if (money == 0)
                    _stop = true;
                return _stop;
            }
            set { _stop = value; }
        }
        public void deposit(int amount)
        {
            lock (this)
            {
                money += amount;
                stop = false;
                income += amount;

            }
        }
        public int draw(int amount)
        {
            lock (this)
            {
                if (money < amount)
                {
                    amount = money;
                    //Console.WriteLine("Bank money not enough!! just get {0}", amount);
                }
                money -= amount;

                outlay += amount;
                return amount;
            }
        }

    }
}
