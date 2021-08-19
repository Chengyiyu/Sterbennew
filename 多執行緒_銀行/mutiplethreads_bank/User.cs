using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace mutiplethreads_bank
{
    class User
    {
        private static Random random = new Random();
        private static string[] NAMES = { "Binzhong", "ZongYee", "Max", "ShengSheng", "Fongshu", "Waterball", "Fireball", "ShengFong", "WangNing" };
        private static int nameIndex = 0;
        private string name;
        private int HoldMoney = 3000;
        private Bank bank;
        public User(Bank bank)
        {
            this.bank = bank;
        }
        public void work()
        {
            if (name == null)
            {
                name = NAMES[++nameIndex % NAMES.Count()];
                Thread.CurrentThread.Name = name;
            }
            while (!bank.stop)
            {
                Thread.Sleep(random.Next(5)*1000);

                if ((random.Next(10) & 1) == 0 && HoldMoney > 0)
                {
                    deposit(random.Next(HoldMoney));
                }
                else
                {
                    draw(random.Next(6000));
                }
            }

        }
        private void deposit(int amount)
        {
            Console.WriteLine("User：{0} depositting {1} dollar ...", Thread.CurrentThread.Name,amount);
            bank.deposit(amount);
            HoldMoney -= amount;
        }
        private void draw(int amount)
        {
            int result = bank.draw(amount);
            Console.WriteLine("User：{0} drawing {1} dollar ... , Get : {2} ", Thread.CurrentThread.Name, amount, result);
            HoldMoney += result;
 
        }
    }
}
