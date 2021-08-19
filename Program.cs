using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace mutiplethreads_bank
{
    class Program
    {
        static Bank bank = new Bank();
        static List<Thread> ThreadList = new List<Thread>();
        public static void Main(string[] args)
        {
     
            GenerateUser();
            while (!bank.stop) {
                Thread.Sleep(50);
                foreach (Thread t in ThreadList)
                    t.Join();
            }
            int result = bank.income - bank.outlay;
            Console.WriteLine("result： total {0}-{1} ={2}",bank.income,bank.outlay,result);
            Console.Read();
        }
        private static void GenerateUser ()
        {
            ThreadList.Add(new Thread(new User(bank).work));
            ThreadList.Add(new Thread(new User(bank).work));
            ThreadList.Add(new Thread(new User(bank).work));
            ThreadList.Add(new Thread(new User(bank).work));
            ThreadList.Add(new Thread(new User(bank).work));
            ThreadList.Add(new Thread(new User(bank).work));
            foreach (Thread t in ThreadList)
                t.Start();
        }
    }
}
